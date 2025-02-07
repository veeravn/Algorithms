package com.vnaidu;

class NegativeSubArrayFinder extends Base {
    private final int [] inputArray;

    public NegativeSubArrayFinder(int [] inputArray) {
        this.inputArray = inputArray;
    }

    public int getNumberOfNegativeSubArrays() {
        int negativeArrayCount=0;
        // Counting number of sub arrays whose summation is negative.
        int sum=0;
        if(inputArray != null && inputArray.length > 0) {
            int len = inputArray.length;
            //for each index in array starting from second element
            //this loop controls the size of the winodws
            for (int i = 1; i <= len; i++) {
                //this loop slides the current window across the array.
                for (int k = 1; k <= len - i + 1; k++) {
                    // sum each index between 0 and i
                    //this loop calculates the sum of the current window and determines if the
                    // sum of the window is negative or not.
                    for (int j = 0; j < i; j++) {
                        sum += inputArray[j + k - 1];
                    }
                    if (sum < 0)
                        negativeArrayCount++;
                    sum = 0;
                }
            }
            /*
            i =1, k=1, j=0
            arr[0]
            k=2
            arr[1]
            k=3
            arr[2]
            k=4
            arr[3]
            k=5
            arr[4]
            i=2,k=1,j=0
            arr[0]+arr[1]
            k=2
            arr[1]

             */
        } else {
            return 0;
        }
        return negativeArrayCount;
    }


// a = [1, -2, 3, -4]
// [1] N
// [1, -2] Y
// [1 ,-2, 3] N
// [1, -2, 3, -4] Y
// [-2] Y
// [-2, 3] N
// [-2, 3, -4] Y
// [3] N
// [3, -4] Y
// [-4] Y

/********************* DO NOT EDIT CODE BELOW THIS COMMENT *********************/

    public static void main(String[] args) {
        int [] subArray = new int [] {1, -2, 4, -5, 1};
        NegativeSubArrayFinder subArrayFinder = new  NegativeSubArrayFinder(subArray);
        if(9 == subArrayFinder.getNumberOfNegativeSubArrays()){
            logger.info("Test passed");
        }

        int [] subArray2 = new int [] {-463,-744,-589,-405,-321,-427,-164,-581,-613,-468,-246,-685,-869,-966,-889,-217,-712,-888,-251,-859,-969,-582,-603,-658,-49,-973,-185,-241,-439,-511,-479,-902,-255,-420,-660,-576,-848,-824,-157,-461,-644,-404,-498,-513,-722,-387,-82,-434,-275,-686,-645,-597,-268,-248,-255,-669,-573,-792,-910,-364,-303,-742,-267,-910,-162,-279,-487,-362,-103,-644,-823,-747,-400,-674,-612,-474,-61,-46,-260,-689,-732,-905,-286,-353,-505,-893,-22,-78,-37,-285,-443,-341,-27,-62,-603,-541,-341,-90,-904,-796};
        subArrayFinder = new  NegativeSubArrayFinder(subArray2);
        if(5050 == subArrayFinder.getNumberOfNegativeSubArrays()) {
            logger.info("Test passed");
        }

        int [] subArray3 = null;
        subArrayFinder = new NegativeSubArrayFinder(subArray3);
        if(0 == subArrayFinder.getNumberOfNegativeSubArrays()) {
            logger.info("Test passed");
        }

        int [] subArray4 = new int[0];
        subArrayFinder = new NegativeSubArrayFinder(subArray4);
        if(0 == subArrayFinder.getNumberOfNegativeSubArrays()) {
            logger.info("Test passed");
        }
    }
}
