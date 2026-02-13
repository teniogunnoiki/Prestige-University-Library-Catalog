public class Branch {
    private int branchID;
    private String name;
    private String location;

    public Branch(int branchID, String name, String location) {
        this.branchID = branchID;
        this.name = name;
        this.location = location;
    }

    public int getBranchID() {
        return branchID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
