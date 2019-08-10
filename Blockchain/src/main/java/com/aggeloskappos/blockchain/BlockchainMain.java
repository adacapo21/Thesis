package com.aggeloskappos.blockchain;

/**
 * Blockchain Main class
 * run the basic functionality of the application
 *
 */
public class BlockchainMain
{
    public static void main( String[] args )
    {
        System.out.println( "****** Blockchain World!******\n" );
        //instantiate the block chain itself
        BlockChain blockChain = new BlockChain();
        //simple miner
        Miner miner = new Miner();

        //Creation of blocks , that will be linked to do the Blockchain
        //each block is connected with the previous one and the next one with their hashes(prev-hash)
        //except of the Genesis block
        Block block0 = new Block(0,"transaction1",Constants.GENESIS_PREV_HASH);
        miner.mine(block0, blockChain);

        Block block1 = new Block(1,"transaction2",blockChain.getBlockChain().get(blockChain.size()-1).getHash());
        miner.mine(block1, blockChain);

        Block block2 = new Block(2,"transaction3",blockChain.getBlockChain().get(blockChain.size()-1).getHash());
        miner.mine(block2, blockChain);

        System.out.println("\n"
                + "BLOCKCHAIN:\n"+blockChain);
        System.out.println("Miner's reward: " + miner.getReward());

    }
}
