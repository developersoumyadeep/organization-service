package in.falconworks.orgservice.hr.domain.core.model;

public enum Designation {
    ED("Executive director"),
    CE("Chief engineer"),
    ACE("Addl. chief engineer"),
    DyCE("Deputy chief engineer"),
    SE("Superintending engineer"),
    DE("Divisional engineer"),
    AE("Assistant engineer"),
    JOT("Jr. operator cum trainee"),
    CM("Charge man"),
    ACM("Asst. charge man"),
    HgSrLM("Higher grade sr. linesman"),
    LM("Linesman"),
    HGSrTSH("Higher grade sr. TSH"),
    TSH("Technical support hand");

    private String longText;

    Designation(String longText) {
      this.longText = longText;
    }

    public String getLongText() {
        return this.longText;
    }
}
