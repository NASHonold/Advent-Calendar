public class Elf {

    private String section;
    private int[] sectionArr;
    private int firstSection;
    private int lastSection;

    public Elf(String section) {
        this.section = section;
        this.sectionArr = makeSecArray();
        this.firstSection = this.sectionArr[0];
        this.lastSection = this.sectionArr[sectionArr.length - 1];

    }

    private int[] makeSecArray() {
        String[] startStop = this.section.split("-");
        int start = Integer.parseInt(startStop[0]);
        int stop = Integer.parseInt(startStop[1]);
        int[] returnArr = new int[stop - start + 1];

        for (int i = 0; i < returnArr.length; i++) {
            returnArr[i] = start;
            start++;
        }
        return returnArr;
    }

    /*
     * Determines if the first section of this elf is greater than or equal to
     * and the last section is less than or equal to the Elf object that is
     * passed to it.
     */
    public boolean isCoveredSection(Elf elf) {

        int otherFirst = elf.getFirstSection();
        int otherLast = elf.getLastSection();

        if (otherFirst <= this.firstSection && otherLast >= this.lastSection)
            return true;
        else
            return false;

    }

    public boolean isOverlapped(Elf elf) {
        int otherFirst = elf.getFirstSection();
        int otherLast = elf.getLastSection();

        int thisFirst = this.firstSection;
        int thisLast = this.lastSection;

        boolean firstInside;
        boolean lastInside;

        firstInside = (thisFirst <= otherLast && thisFirst >= otherFirst);
        lastInside = (thisLast <= otherLast && thisLast >= otherFirst);

        if(firstInside || lastInside)
            return true;
        else   
            return false;

    }

    private int getFirstSection() {
        return this.firstSection;
    }

    private int getLastSection() {
        return this.lastSection;
    }

}
