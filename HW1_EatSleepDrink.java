public class HW1_EatSleepDrink {


    /**
     * 3 points
     *
     * Compute net hourly pay including tips. Tips are given proportionate to hourly rate.
     *
     * Note: We are ignoring taxes in this assignment.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 value will be 0.2
     * @return Net pay including hourly rate and tips
     */
    public static double netHourlyPayRate(double hourlyPayRate, double tipRate){
    	double totalTip = hourlyPayRate*tipRate;
    	double totalHourly = hourlyPayRate + totalTip;

        return totalHourly;
    }


    /**
     * 4 points
     *
     * Compute the total weekly cost for food and drinks given their individual daily costs. Use a full 7 day week for
     * computations (not a 5 day work week).
     *
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @return Total cost of food and drinks for a 7 day week
     */
    public static double totalWeeklyCost(double dailyFoodCost, double dailyBeverageCost){
    	double dailyConsumptionCost = dailyFoodCost + dailyBeverageCost;
    	double weeklyFatty = dailyConsumptionCost*7.0;

        return weeklyFatty;
    }


    /**
     * 3 points
     *
     * Compute the total number of hours needed to earn an A in all courses for a given amount of credit hours.
     * Assume it's necessary to spend 1 hour/week in class and 2 hours/week outside of class for each credit hour
     * registered to earn A's in all courses for a semester.
     *
     * @param creditHours  Number of credit hours registered
     * @return Total number of hours spent on courses in a single week
     */
    public static double weeklyEducationTime(int creditHours){
    	double weeklyInHours = 1.0;
    	double weeklyOutHours = 2.0;
    	double totalWeeklyHoursPerCredit = weeklyInHours + weeklyOutHours;
    	double totalWeeklyHours = creditHours*totalWeeklyHoursPerCredit;
    	

        return totalWeeklyHours;
    }


    /**
     * 10 points
     *
     * Can you afford to eat, sleep, and drink each week while still performing well in your classes and having the
     * free time you desire? Make computations based on a single 7 day week (168 hours) and determine if there is
     * enough time in the week to do everything. You will need to earn cash at your job (given pay and tip rate)
     * to earn enough money to afford food and drink for the week. To avoid becoming robots who only work and study, 
     * also factor in the number of hours spent sleeping and chilling which includes everything that isn't work or school.
     *
     * Note: You can, and should, call the previous 3 functions to help you complete this function and reduce clutter.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @return true if it's possible to afford a week with this lifestyle, false otherwise
     */
    public static boolean canEatSleepDrink(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                           double dailyBeverageCost, int creditHours, int dailySleepAndChill){
    	double totalHourlyPayRate = netHourlyPayRate(hourlyPayRate, tipRate);
    	double weeklyConsumptionCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	double weeklyEducationTime = weeklyEducationTime(creditHours);
    	
    	double dayHours = 24.0;
    	double weekHours = dayHours*7.0;
    	
    	double weeklyHoursAfterEducation = weekHours - weeklyEducationTime;
    	double weeklySleepAndChill = dailySleepAndChill*7.0;
    	double weeklyHoursLeftForWork = weeklyHoursAfterEducation - weeklySleepAndChill;
    	if(weeklyHoursLeftForWork*totalHourlyPayRate >= weeklyConsumptionCost){
    		return true;
    	}
    	

        return false;
    }


    /**
     * 10 points
     *
     * Can you afford to eat, sleep, and drink each week while still performing well in your classes and getting the
     * sleep and free time you desire? For this function you must also factor in the amount of cash at the beginning 
     * of the week as well as the cash needed for random purchases throughout the week.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return true if it's possible to afford a week with this lifestyle, false otherwise
     */
    public static boolean canEatSleepDrink(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                           double dailyBeverageCost, int creditHours, int dailySleepAndChill,
                                           double startingCash, double randomSpending){
    	double totalHourlyPayRate = netHourlyPayRate(hourlyPayRate, tipRate);
    	double weeklyConsumptionCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	double weeklyEducationTime = weeklyEducationTime(creditHours);
    	
    	double dayHours = 24.0;
    	double weekHours = dayHours*7.0;
    	
    	double weeklyHoursAfterEducation = weekHours - weeklyEducationTime;
    	double weeklySleepAndChill = dailySleepAndChill*7.0;
    	double weeklyHoursLeftForWork = weeklyHoursAfterEducation - weeklySleepAndChill;
    	
    	double weeklyEarnings = weeklyHoursLeftForWork*totalHourlyPayRate;
    	double totalWeeklyMoney = weeklyEarnings + startingCash;
    	
    	double totalWeeklyExpenses = weeklyConsumptionCost + randomSpending;
    	
    	
    	
    	if(totalWeeklyMoney >= totalWeeklyExpenses){
    		return true;
    	}
    	
    	
    	
        return false;
    }

    /**
     * 10 points
     *
     * Return the maximum number of credits hours that can be taken with an A while maintaining the desired lifestyle. 
     * The criteria are the same as the previous function except the number of credit hours is not given. Compute and 
     * return the maximum number of credit hours that can be taken while maintaining this lifestyle.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return the maximum number of credits that can be taken while earning an A and maintaining the given lifestyle
     */
    public static int maximumCredits(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                     double dailyBeverageCost, int dailySleepAndChill,
                                     double startingCash, double randomSpending){
    	
    	double totalHourlyPayRate = netHourlyPayRate(hourlyPayRate, tipRate);
    	double weeklyConsumptionCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	
    	double weeklyInHours = 1.0;
    	double weeklyOutHours = 2.0;
    	double totalWeeklyHoursPerCredit = weeklyInHours + weeklyOutHours;
    	
    	double dayHours = 24.0;
    	double weekHours = dayHours*7.0;
    	
    	double weeklySleepAndChill = dailySleepAndChill*7.0;
    	 
    	double totalWeeklyExpenses = weeklyConsumptionCost + randomSpending;
    	
    	
    	double hoursNeededToWork = (totalWeeklyExpenses - startingCash) / totalHourlyPayRate;
    	
    	double timeLeftForSchool = (weekHours - hoursNeededToWork) - weeklySleepAndChill;
    	
    	double maximumNumberOfCreditHoursThatCanBeTaken = timeLeftForSchool / totalWeeklyHoursPerCredit;


        return (int)maximumNumberOfCreditHoursThatCanBeTaken;
    }


    /**
     * Challenge Question
     * Bonus: 10 points
     *
     * Return the best possible semester grade given the following chart of time multipliers. The multiplier
     * is the number of hours spent outside of class per week per credit hour. This multiplier does not include the 
     * 1 hour/week spent in class for each credit hour.
     *
     * Multiplier | Grade
     *   >= 2.0   |  A
     *   >= 1.75  |  A-
     *   >= 1.5   |  B+
     *   >= 1.25  |  B
     *   >= 1.0   |  B-
     *   >= 0.75  |  C+
     *   >= 0.5   |  C
     *   >= 0.25  |  C-
     *   >= 0.1   |  D
     *   < 0.1    |  F
     *
     * Note: depending on the types of courses taken this chart may not be exactly accurate, but we will assume these
     * numbers are true for this function.
     *
     * @param hourlyPayRate  Base pay rate per hour
     * @param tipRate  Average tip rate (not percentage) from customers. Example: If your tip rate is 20% this
     *                 parameter will be 0.2
     * @param dailyFoodCost  Total cost of food for a single day
     * @param dailyBeverageCost  Total cost of drinks for a single day
     * @param creditHours  Number of credit hours registered
     * @param dailySleepAndChill  hours spent each day sleeping or chilling (anything that's not work or school)
     * @param startingCash          Amount of cash at the beginning of the week
     * @param randomSpending        Amount of cash needed for random purchases throughout the week
     * @return The highest grade possible for the given number of credits and lifestyle choices
     */
    public static String maximumGrade(double hourlyPayRate, double tipRate, double dailyFoodCost,
                                      double dailyBeverageCost, int creditHours, int dailySleepAndChill,
                                      double startingCash, double randomSpending){
    	
    	//boolean callPreviousExample = canEatSleepDrink(hourlyPayRate, tipRate, dailyFoodCost, dailyBeverageCost, creditHours, dailySleepAndChill, startingCash, randomSpending);
    	//double totalWeeklyHoursPerCredit = weeklyInHours + weeklyOutHours;
    	//double weeklyEducationTime = weeklyEducationTime(creditHours);
    	//double weeklyOutHours = 2.0;
    	//double weeklyInHours = 1.0;
    	//double maximumNumberOfCreditHoursThatCanBeTaken = timeLeftForSchool / totalWeeklyHoursPerCredit;

    	
    	
    	
    	double totalHourlyPayRate = netHourlyPayRate(hourlyPayRate, tipRate);
    	double weeklyConsumptionCost = totalWeeklyCost(dailyFoodCost, dailyBeverageCost);
    	
    	
    	
    	double dayHours = 24.0;
    	double weekHours = dayHours*7.0;
    	
    	double totalWeeklyExpenses = weeklyConsumptionCost + randomSpending;
    	
    	double hoursNeededToWork = (totalWeeklyExpenses - startingCash) / totalHourlyPayRate;
    	
    	
    	double weeklySleepAndChill = dailySleepAndChill*7.0;
    	
    	double timeLeftForSchool = (weekHours - hoursNeededToWork) - weeklySleepAndChill;
    	
    	
    	
    	
    	
    	String answer = "";
    	
    	double multiplier = (timeLeftForSchool - creditHours) / (creditHours);
    	
    	
    	if(multiplier >= 2.0){
    		answer = "A";}
    	else if(multiplier >= 1.75 && multiplier < 2.0){
    		answer = "A-";}
    	else if(multiplier >= 1.5 && multiplier < 1.75){
    		answer = "B+";}
    	else if(multiplier >= 1.25 && multiplier < 1.5){
    		answer = "B";}
    	else if(multiplier >= 1.0 && multiplier < 1.25){
    		answer = "B-";}
    	else if(multiplier >= 0.75 && multiplier < 1.0){
    		answer = "C+";}
    	else if(multiplier >= 0.5 && multiplier < 0.75){
    		answer = "C";}
    	else if(multiplier >= 0.25 && multiplier < 0.5){
    		answer = "C-";}
    	else if(multiplier >= 0.1 && multiplier < 0.25){
    		answer = "D";}
    	else{
    		answer = "F";}
    	return answer;
    	
    	
    	
    	
//    	double hoursNeededToWork = (totalWeeklyExpenses - startingCash) / totalHourlyPayRate;
    	
//    	double timeLeftForSchool = weekHours - hoursNeededToWork - weeklySleepAndChill;
//   	double maximumNumberOfCreditHoursThatCanBeTaken = timeLeftForSchool / totalWeeklyHoursPerCredit;
    	
    	


    }


    public static void main(String[] args) {
    
    	double hourlyPayRate = 10.0;
    	double tipRate = 0.2;
    	double dailyFoodCost = 30.0;
    	double dailyBeverageCost = 10.0;
    	int creditHours = 15;
    	int dailySleepAndChill = 16;
    	double startingCash = 100.0;
    	double randomSpending = 50.0;
    	
    	
    	String bonusQuestion = maximumGrade(hourlyPayRate, tipRate, dailyFoodCost, dailyBeverageCost, creditHours, dailySleepAndChill, startingCash, randomSpending);
    	System.out.println(bonusQuestion);
    	
    	


    }

}