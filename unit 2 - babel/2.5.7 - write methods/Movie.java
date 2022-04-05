public class Movie {
    private String movieTitle;
    private double movieDuration;
    private int movieRating;

    public Movie(String t, double d)
    {
        movieTitle = t;
        movieDuration = d;
        movieRating = 0;
    }

    public String getMTitle()
    {
        return movieTitle;
    }

    public double getDuration()
    {
        return movieDuration;
    }

    public int getMRating()
    {
        return movieRating;
    }
    
    public String toString() 
    {
      String info = "\"" + movieTitle + "\", with a duration of " + movieDuration + " hours.";
      if (movieRating != 0) 
      { 
        info += ", rating is " + movieRating;
      }
      return info;
    }

    public void setMTitle(String t)
    {
        movieTitle = t;
    }

    public void setMDuration(double d)
    {
        movieDuration = d;
    }

    public int adjustMRating(int movieRate)
    {
        if ((movieRating + movieRate >= 0) || (movieRating + movieRate <= 10))
        {
            movieRating += movieRate;
        }
        return movieRating;
    }

    public boolean equals(Movie m)
    {
        if(this.movieTitle.equals(m.movieTitle))
        {
            return true;
        }
        return false;
    }
}
