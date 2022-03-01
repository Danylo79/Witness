package dev.dankom.witness.logger.anim;

import dev.dankom.logger.LogManager;
import dev.dankom.logger.abztract.DefaultLogger;
import dev.dankom.logger.interfaces.ILogger;
import dev.dankom.operation.IOperation;
import dev.dankom.util.general.ColorUtil;
import dev.dankom.util.general.MathUtil;

import java.util.ArrayList;
import java.util.List;

public class Progressbar {
    private static ILogger logger = LogManager.addLogger("progress-bar", new DefaultLogger());
    private List<IOperation> operations;
    private int totalOperations;
    private int done;

    public Progressbar(List<IOperation> operations) {
        operations.add(new IOperation(logger) {
            @Override
            public String getName() {
                return "Done!";
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        this.operations = operations;
        this.totalOperations = operations.size() - 1;
        this.done = 0;
        progressPercentage(operations.get(0).getName());
    }

    public Progressbar start() {
        for (IOperation operation : operations) {
            doOperation();
        }
        return this;
    }

    public void doOperation() {
        operations.get(done).run();

        if (done == totalOperations) {
            done();
            return;
        }

        done++;
        progressPercentage(operations.get(done).getName());
    }

    public void progressPercentage(String operation) {
        progressPercentage(operation, done, totalOperations);
    }

    private void progressPercentage(String operation, int done, int total) {
        int size = 20;
        String iconLeftBoundary = "[";
        String iconDone = ColorUtil.ANSI_GREEN + "#" + ColorUtil.ANSI_RESET;
        String iconRemain = ColorUtil.ANSI_RED + "-" + ColorUtil.ANSI_RESET;
        String iconRightBoundary = "]";

        if (done > total) {
            throw new IllegalArgumentException();
        }
        int donePercents = (100 * done) / total;
        int doneLength = size * donePercents / 100;

        StringBuilder bar = new StringBuilder(iconLeftBoundary);
        for (int i = 0; i < size; i++) {
            if (i < doneLength) {
                bar.append(iconDone);
            } else {
                bar.append(iconRemain);
            }
        }
        bar.append(iconRightBoundary);

        System.out.print("\rProgress: [" + ColorUtil.ANSI_PURPLE + donePercents + "%" + ColorUtil.ANSI_RESET + "] " + ColorUtil.ANSI_RESET + bar + " - " + operation);

        if (done == total) {
            System.out.print("\n");
        }

        step(operation);
    }

    public static void test() {
        List<IOperation> operations = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            operations.add(new IOperation(logger) {
                @Override
                public String getName() {
                    return "" + MathUtil.randDouble(0, 10000);
                }

                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        new Progressbar(operations).start();
    }

    //Hooks
    public void done() {
    }

    public void step(String operation) {
    }
}
