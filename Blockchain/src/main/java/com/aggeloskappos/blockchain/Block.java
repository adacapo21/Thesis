package com.aggeloskappos.blockchain;

import  java.util.Date;
//every block is cryptographically connected one eachother with hashes
public class Block {

    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;  //identify the block - something like a fingeprint
    private String previousHash;
    private String transaction;

    public Block(int id, String transaction, String previousHash) {
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash() {
        String dataToHash = Integer.toString(id)+previousHash+Long.toString(timeStamp)+Integer.toString(nonce)+transaction.toString();
        String hashValue = SHA256Helper.generateHash(dataToHash);
        this.hash = hashValue;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    @Override
    public String toString() {
        return "- ID " +this.id  +  "\n- Number of this Transaction is : " + this.transaction +  "\n- This Hash is: " + this.hash
                + "\n- The Previous Hash of this block is : " + this.previousHash + "\n\n";

    }
}
