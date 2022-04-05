/*
 * Problem 2 Sell My Pet Food
 */
public class Main //TargetedAd
{
  public static void main(String[] args)
  {
    /*  
     * TODO:
     * PREPARATION WORK
     * (1) Create a file called targetWords.txt. Populate this file with words on each line that you think would determine if a user is a dog or cat owner.
     * 
     * PROGRAMMING
     * (2) Create a new DataCollector object and set the data to "socialMediaPostsSmall.txt" and "targetWords.txt"
     *     Important: Use the socialMedialPostsSmall to create your algorithm. Using a small file will help you generate your solution quicker and give you the ability to double check your work.
     * (3) Create a String variable to hold the names of all the user. (The first word of every post is a person's username)
     * (4) Compare each user's post to each target word. If a user mentions a target word, add their username to the String of users. Separate usernames with a space. 
     *         Hint: You can use loops to look through each word. 
     *         Hint2: You can use indexOf to check if a word is in a user post. 
     * (5) Once you have all the users, use your DataCollector's prepareAdvertisement method to prepare a file with all users and the advertisement you will send them.
     *         Additional Info: The prepareAdvertisement creates a new file on your computer. Check the posts of some of the usernames to make sure your algorithm worked.
     * 
     * THE FINAL SOLUTION
     * (6) Your solution should work with the socialMedialPostsSmall.txt. Modify your DataCollector initialization so you use the socialMediaPosts.txt. You should now have a larger file of users to target.
     */


    /* YOUR CODE HERE */
    String username = ""; 
    String targetUsers = ""; //TODO 3
    String catUsers = "";
    String dogUsers = "";

    // arrays for segregation
    String[] catArray = new String[] {"cat","cats","kitty","kitten"};
    String[] dogArray = new String[] {"dog","dogs","pup","puppy","bark"};

    //TODO 2
    DataCollector dCollector = new DataCollector();
    dCollector.setData("socialMediaPostsSmall.txt", "targetWords.txt");
    
    dCollector.printAllPosts(); //test 
    dCollector.printAllTargetWords(); //test 

    //TODO 3 & 4
    String socialMediaPost = dCollector.getNextPost();
    while (socialMediaPost != "NONE") {
      String targetWord = dCollector.getNextTargetWord();
      username = socialMediaPost.substring(0, socialMediaPost.indexOf(" ")) + " ";
      
      while (targetWord != "NONE") {
        if (socialMediaPost.contains(targetWord) && !targetUsers.contains(username)) {
          targetUsers += socialMediaPost.substring(0, socialMediaPost.indexOf(" ")) + " ";
          for (int i = 0; i < catArray.length; i++)
          {
            if (socialMediaPost.contains(catArray[i]) && !catUsers.contains(username))
            {
              catUsers += socialMediaPost.substring(0, socialMediaPost.indexOf(" ")) + " ";
            }
          }
        }
        targetWord = dCollector.getNextTargetWord();
      }

      socialMediaPost = dCollector.getNextPost();
    }

    // System.out.println(usernames); //test
    System.out.println(targetUsers); //test
    System.out.println(catUsers);
     
    dCollector.prepareAdvertisement("food_advert", targetUsers, "buy our yummeries"); 
    dCollector.prepareAdvertisement("cat_advert", catUsers, "buy our cat yummeries");
    

  }

}
