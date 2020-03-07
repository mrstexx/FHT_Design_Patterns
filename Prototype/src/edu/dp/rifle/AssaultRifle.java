package edu.dp.rifle;

import java.util.List;

public class AssaultRifle extends Rifle {

    private boolean supportAttachments;
    private List<String> attachments;

    public AssaultRifle(int magazineSize, double hitPoints, double weight, double length, double caliber, String modelName,
                        boolean supportAttachments, List<String> attachments) {
        super(magazineSize, hitPoints, weight, length, caliber, modelName);
        this.attachments = attachments;
        this.supportAttachments = supportAttachments;
    }

    public boolean isSupportAttachments() {
        return supportAttachments;
    }

    public void setSupportAttachments(boolean supportAttachments) {
        this.supportAttachments = supportAttachments;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public AssaultRifle clone() throws CloneNotSupportedException {
        return (AssaultRifle) super.clone();
    }
}
