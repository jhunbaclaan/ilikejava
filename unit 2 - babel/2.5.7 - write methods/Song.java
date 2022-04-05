public class Song {
    private String title;
    private String artist;
    private Double duration;
    private int rating;

    public Song (String t, String a, Double d)
    {
        title = t;
        artist = a;
        duration = d;
    }

    public String getSongTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public Double getSongDuration()
    {
        return duration;
    }

    public String toString() 
    {
      String info = "\"" + title + " by " + artist + "\", with a duration of " + duration + " minutes.";
      if (rating != 0) 
      { 
        info += ", rating is " + rating;
      }
      return info;
    }

    public void setSongTitle(String t)
    {
        title = t;
    }

    public void setArtist(String a)
    {
        artist = a;
    }

    public void setSongDuration(Double d)
    {
        duration = d;
    }

    public int adjustSongRating(int songRate)
    {
        if ((rating + songRate >= 0) || (rating + songRate <= 10))
        {
            rating += songRate;
        }
        return rating;
    }
    
    public boolean equals(Song s)
    {
        if(this.title.equals(s.title) && this.artist.equals(s.artist))
        {
            return true;
        }
        return false;
    }
}
