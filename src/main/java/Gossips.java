import java.util.ArrayList;
import java.util.List;

public class Gossips {
    private List<Gossip> listOfGossip;
    private ParserImpl gossipParser = ParserImpl.getParser();
    private Gossip fromGossip;
    private Gossip toGossip;
    private String message;
    private List<Gossip> listOfSay;
    private int indexOfSpread;

    public Gossips(String...gossips) {
        this.listOfGossip = new ArrayList<Gossip>();
        this.listOfSay = new ArrayList<Gossip>();
        this.message = "";
        this.addGossips(gossips);
        this.indexOfSpread = 0;
    }

    private void addGossips(String[] gossips) {
        for(int iterator = 0; iterator < gossips.length; iterator++) {
            this.listOfGossip.add(gossipParser.parseGossip(gossips[iterator]));
        }
    }

    public Gossips from(String gossip) {
        this.message = null;
        for(int iterator = 0; iterator < this.listOfGossip.size(); iterator++) {
            if(this.listOfGossip.get(iterator).equals(gossip))
                this.fromGossip = this.listOfGossip.get(iterator);
        }
        return this;
    }

    public Gossips say(String message) {
        this.toGossip = null;
        this.message = message;
        return this;
    }

    public Gossips to(String gossip) {
        try {
            this.toGossip = this.getGossip(gossip);
        } catch (NoGossipFindException e) {
            e.printStackTrace();
        }

        if(isMessageOrGossip()) {
            this.toGossip.sayTo(this.message);
            this.listOfSay.add(this.toGossip);
        }
        else
            this.fromGossip.gossipTo(this.toGossip);
        return this;
    }

    private boolean isMessageOrGossip() {
        return message != null;
    }


    private Gossip getGossip(String gossip) throws NoGossipFindException {
        for(int iterator = 0; iterator < this.listOfGossip.size(); iterator++) {
            if(this.listOfGossip.get(iterator).equals(gossip)) {
                return this.listOfGossip.get(iterator);
            }
        }
        throw new NoGossipFindException();
    }

    public String ask(String gossip) {
        Gossip askGossip = null;
        try {
            askGossip =this.getGossip(gossip);
        } catch (NoGossipFindException e) {
            e.printStackTrace();
        }
        return askGossip.ask();
    }

    public void spread() {
        this.listOfSay.add(this.listOfSay.get(this.indexOfSpread).spread());
        this.indexOfSpread++;
    }
}
