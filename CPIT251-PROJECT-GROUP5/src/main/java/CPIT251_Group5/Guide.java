
package CPIT251_Group5;
//Hadeel Alomari 2206020

    public class Guide {
    
    private int guideID;
    private String title;
    private String category;
    private String status;

    public Guide(int guideID, String title, String category, String status) {
        this.guideID = guideID;
        this.title = title;
        this.category = category;
        this.status = status;
    }

    public int getGuideID() {
        return guideID;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Guide ID: " + guideID + ", Title: " + title + ", Category: " + category + ", Status: " + status;
    }
}
