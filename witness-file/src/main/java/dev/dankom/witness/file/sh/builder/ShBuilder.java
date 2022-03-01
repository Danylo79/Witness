package dev.dankom.witness.file.sh.builder;

import dev.dankom.file.sh.builder.ShExecution;

import java.util.ArrayList;
import java.util.List;

public class ShBuilder {
    private List<ShExecution> executions = new ArrayList<>();
    
    public void exec(ShExecution exec) {
        executions.add(exec);
    }

    public void exec(String command, String[] flags, String[] params) {
        executions.add(new ShExecution(command, flags, params) );
    }
    
    public String build() {
        StringBuilder builder = new StringBuilder();
        for (ShExecution exec : executions) {
            if (exec == executions.get(executions.size() - 1)) {
                builder.append(exec.build());
                continue;
            }
            builder.append(exec.build() + "\n");
        }
        return builder.toString();
    }
}
