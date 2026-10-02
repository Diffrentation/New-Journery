/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let maxwater=0;
    let i=0;
    let j=height.length-1;
    while(i<j){
      let width=j-i;
      let minheight= Math.min(height[i],height[j]);
      let area=width*minheight;
       maxwater= Math.max(area,maxwater);
       height[i]<height[j]?i++:j--;
    }
    return maxwater;
};