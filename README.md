# Between-Two-Sets
You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:
        The elements of the first array are all factors of the integer being considered
        The integer being considered is a factor of all elements of the second array

These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.
getTotalX has the following parameter(s):
a: an array of integers
b: an array of integers

# Function Description:
Approach with LCM and min value of list b Logic: 
1) For all elements of array1 to be factors of given integer, the given integer must be A multiple of LCM of all elements of array one. 2) Given integer must lie between the max_list_a and min_list_b as per function definition hence the main while loop executes this logic.


public static int getTotalX(List<Integer> a, List<Integer> b) {
int lcm_org=1;
    for(int j=0;j<a.size();j++){
    lcm_org=lcm_f(lcm_org,a.get(j));
    }

    int mul=1,count=0;
    int lcm=lcm_org;
    while(lcm<=Collections.min(b)){
    boolean flag=true;
    for(int i=0;i<b.size();i++){
        if(b.get(i)%lcm!=0){
            flag=false;
        }
        else{
            continue;
        }
    }

    if(flag==true){
        count++;
    }
    mul++;
    lcm=lcm_org*mul;
}
return count;
}

