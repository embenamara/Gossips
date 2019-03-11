public interface Parser {
    String GOSSIP_SEPARATOR = " ";
    int INDEX_OF_STATUT = 0;
    int INDEX_OF_NAME_OF_GOSSIP = 1;
    String DOCTOR_STATUT = "Dr";

    Gossip parseGossip(String gossip);


}
