public class DiscordUser {

    private String name;
    private int id;
    private String discriminator;
    private boolean bot;

    public DiscordUser(String name, int id, String discriminator, boolean bot) {
        this.name = name;
        this.id = id;
        this.discriminator = discriminator;
        this.bot = bot;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public boolean isBot() {
        return bot;
    }
}
