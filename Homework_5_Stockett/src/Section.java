public class Section implements Comparable<Section>{
    private String courseId;
    private String crn;
    private String title;
    private String instructor;
    private int seatsAvailable;
    private boolean closed;

    public Section(String courseId, String crn, String title, String instructor, int seatsAvailable){
        setCourseId(courseId);
        setCrn(crn);
        setTitle(title);
        setInstructor(instructor);
        setSeatsAvailable(seatsAvailable);
    }
    public Section(){
        this("___xxx", "xxxxx", "??????", "Staff", 0);
    }

    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public void setCrn(String crn){
        this.crn = crn;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setInstructor(String instructor){
        this.instructor = instructor;
    }
    public void setSeatsAvailable(int seatsAvailable){
        this.seatsAvailable = seatsAvailable;
        setIsOpen(seatsAvailable);
    }
    private void setIsOpen(int seatsAvailable){
        this.closed = seatsAvailable <= 0;
    }



    public String getCourseId(){
        return courseId;
    }
    public String getCrn(){
        return crn;
    }
    public String getTitle(){
        return title;
    }
    public String getInstructor(){
        return instructor;
    }
    public int getSeatsAvailable(){
        return seatsAvailable;
    }
    public boolean isClosed(){
        return closed;
    }

    @Override
    public String toString(){
        String result = "";
        result = String.format("%-10s %-7s %-30s  %-20s %-3d %-1s", courseId, crn, title, instructor, seatsAvailable,
                closed ? "Closed" : "");
        return result;
    }


    @Override
    public int compareTo(Section other) {
        int result = 0;
        result = this.courseId.compareTo(other.courseId);

        if(result == 0){
            result = this.crn.compareTo(other.crn);
        }
        return result;
    }
}
