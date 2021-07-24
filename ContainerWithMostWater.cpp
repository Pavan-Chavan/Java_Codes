/*
//Title:- container with most water
//Code:- Pavan Chavan
//date:- 24-07-2021
//email:-pavan.21920161@viit.ac.in

 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find 
 two lines, which, together with the x-axis forms a container, such that the container contains the 
 most water.

 Notice that you may not slant the container.
*/

class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxWater=0,i=0,end=height.size()-1,temp;
        while(i<end)
        {
            temp=min(height[i],height[end]);
            if(maxWater<(temp*(end-i)))
                maxWater=temp*(end-i);
            if(height[i]<height[end])
                i++;
            else
                end--;
        }
    return maxWater;
    }
};