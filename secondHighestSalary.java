public class secondHighestSalary 
{
    public static void main(String[] args) 
    {
        int largest = 0;    //setting the initial values of largest salary and second largest to 0 
        int secondLargest = 0;

        int salaries[] = {50_000, 35_000, 70_000, 10_000};

        for (int currentSalary : salaries)
        {
            if (currentSalary > largest)    // setting current value as new highest salary. i.e `largest` after setting `secondLargest` with the previous `largest` value  
            {
                secondLargest = largest;
                largest = currentSalary;
            }

            else if ( (currentSalary > secondLargest) && (currentSalary != largest) )    // current value is greater than `secondLargest` but not same as `largest`
            {
                secondLargest = currentSalary;    //so updating the value of secondLargest with the new value
            }
        }

        System.out.println("Largest Salary : " + largest);
        System.out.println("Second Largest Salary : " + secondLargest);
    }
}
