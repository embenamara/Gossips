public class ParserImpl implements Parser {
    private static ParserImpl instance;

    private ParserImpl() {}

    public static ParserImpl getParser() {
        if(instance == null)
            instance = new ParserImpl();
        return instance;
    }

    public Gossip parseGossip(String gossip){
        String gossipUnit[] = gossip.split(GOSSIP_SEPARATOR);
        return Gossip.initGossip(gossipUnit[INDEX_OF_STATUT], gossipUnit[INDEX_OF_NAME_OF_GOSSIP]);
    }
}
