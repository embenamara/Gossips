public class Gossip {
    private String statut;
    private String nameOfGossip;
    private Gossip toGossip;
    private String sayGossip;

    private Gossip(String statut, String nameOfGossip) {
        this.statut = statut;
        this.nameOfGossip = nameOfGossip;
        this.sayGossip = "";
    }

    public static Gossip initGossip(String statut, String nameOfGossip) {
        return new Gossip(statut, nameOfGossip);
    }

    public boolean equals(String gossip) {
        return gossip.equals(this.nameOfGossip);
    }

    public void gossipTo(Gossip toGossip) {
        this.toGossip = toGossip;
    }

    public void sayTo(String message) {
        if(sayGossip != "")
            this.sayGossip += ", ";


        if(isDoctor())
            this.sayGossip += message;
        else
            this.sayGossip = message;
    }

    public String ask(){
        return this.sayGossip;
    }

    public Gossip spread() {
        this.toGossip.sayTo(this.sayGossip);
        this.sayGossip = "";
        return toGossip;
    }

    public String toString() {
        return nameOfGossip;
    }

    private boolean isDoctor(){
        return this.statut.equals(Parser.DOCTOR_STATUT);
    }

}
