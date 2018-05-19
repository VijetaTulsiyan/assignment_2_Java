package s_n.connection;
//auther:Shuai Gao
//Student number:s3596156

//Creating Subclass of the Couple class called Family
public class Family extends Couple {

    //COnstructor
    public Family(String name1, String name2, String name3) {
        super(name1, name2, name3);
        

    }

//Method to check if the child has parents in the Couple class and print their parents name
//Overrides family method in Couple class
    @Override
    public String family(String cheak) {
        super.family(cheak);

        String father = super.getFather();
        String mother = super.getMother();
        String child = super.getChild();
        int sex = super.getSex();
        String find = null;
        if (cheak.trim().equals(father)) {// compare input name1
            if (sex == 1) {
                find = (1 + child + ",");

            } else if (super.getSex() == 0) {
                find = (0 + child + ",");

            }
        }

        if (cheak.trim().equals(mother)) {// compare input name2
            if (sex == 1) {
                find = (1 + child + ",");

            } else if (sex == 0) {
                find = (0 + child + ",");
            }

        }

        if (cheak.equals(child)) {
            find = (father + "," + mother);

        }

        return find;
    }

    public void deletChild() {
        super.setChild(null);
    }

}
