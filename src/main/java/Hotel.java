public class Hotel {
    private String name;
    private int stars;
    private double taxRegular;
    private double taxReward;
    private double taxRegularWeekend;
    private double taxRewardWeekend;

    public Hotel(String name, int stars, double taxRegular, double taxReward, double taxRegularWeekend, double taxRewardWeekend){
        this.name = name;
        this.stars = stars;
        this.taxRegular = taxRegular;
        this.taxReward = taxReward;
        this.taxRegularWeekend = taxRegularWeekend;
        this.taxRewardWeekend = taxRewardWeekend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public double getTaxRegular() {
        return taxRegular;
    }

    public void setTaxRegular(double taxRegular) {
        this.taxRegular = taxRegular;
    }

    public double getTaxReward() {
        return taxReward;
    }

    public void setTaxReward(double taxReward) {
        this.taxReward = taxReward;
    }

    public double getTaxRegularWeekend() {
        return taxRegularWeekend;
    }

    public void setTaxRegularWeekend(double taxRegularWeekend) {
        this.taxRegularWeekend = taxRegularWeekend;
    }

    public double getTaxRewardWeekend() {
        return taxRewardWeekend;
    }

    public void setTaxRewardWeekend(double taxRewardWeekend) {
        this.taxRewardWeekend = taxRewardWeekend;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                '}';
    }
}
