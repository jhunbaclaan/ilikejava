public class MediaLibRunnerStatic {
    public static void main(String[] args)
    {
        MediaLib.changeOwner("j hun");
        System.out.println(MediaLib.getOwner() + "'s library");

        MediaLib.owner = "paul blart";
        System.out.println(MediaLib.owner + "'s library");

        System.out.println(MediaLib.getNumEntries());

        MediaLib slurpee = new MediaLib();
        Book cannot = new Book("test", "person");
        slurpee.addBook(cannot);

        MediaLib grinning = new MediaLib();
        Movie eyeballs = new Movie("watch", 4.2);
        grinning.addMovie(eyeballs);

        System.out.println(cannot);
        System.out.println(eyeballs);
        System.out.println(MediaLib.getNumEntries());

        MediaLib bartek = new MediaLib();
        Song eardrums = new Song("wintersleep", "tennyson", 3.3);
        bartek.addSong(eardrums);

        System.out.println(eardrums);
        System.out.println(MediaLib.getNumEntries());
    }
}
