package dev.dankom.witness.file.sh.builder;

public class ShExecution {
    private final String command;
    private final String[] flags;
    private final String[] params;

    public ShExecution(String command, String[] flags, String[] params) {
        this.command = command;
        this.flags = flags;
        this.params = params;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        builder.append(command + " ");
        for (String s : flags) {
            builder.append(s + " ");
        }
        for (String s : params) {
            if (s.equalsIgnoreCase(params[params.length - 1])) {
                builder.append(s);
                continue;
            }
            builder.append(s + " ");
        }
        return builder.toString();
    }
}
