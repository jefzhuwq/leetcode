package leetcode;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights
 * 846. Hand of Straights
 */
public class Hand_of_Straights {
    /**
     * idea: treemap, key is card, value is how many cards
     * time: O(n * (n/w)), n is elements in hand array, w is group size
     * space: O(n) as we define treemap.
     * @param hand
     * @param w
     * @return
     */
    public boolean isNStraightHand(int[] hand, int w) {
        // define treemap, and key is the card, value is how many cards.
        // treemap is sorted by keys ascending.
        TreeMap<Integer, Integer> card_counts = new TreeMap<>();
        for (int card : hand) {
            if (!card_counts.containsKey(card)) {
                card_counts.put(card, 1);
            } else {
                card_counts.replace(card, card_counts.get(card) + 1);
            }
        }
        // how many card in each card.
        System.out.println("after initialize treemap: " + card_counts);

        while (card_counts.size() > 0) {
            // first key should be smallest (lowest value)
            int first_card = card_counts.firstKey();
            for (int i = first_card; i < first_card + w; i++) {
                // if we can't find subsequent number, means we failed
                if (!card_counts.containsKey(i)) {
                    return false;
                }
                int count = card_counts.get(i);
                // after draw the card from treemap, we need to update the treemap, remove the card if there's no card in this number.
                if (count == 1) {
                    card_counts.remove(i);
                } else {
                    card_counts.replace(i, card_counts.get(i) - 1);

                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[] hand = new int[] {1,2,3,6,2,3,4,7,8};
        int w = 3;
        System.out.println(isNStraightHand(hand, w));
    }
}
