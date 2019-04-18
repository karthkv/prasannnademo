Feature: Lowest Price 
@LowestPrice
 Scenario Outline: Getting the lowest price for the flights
	 Given "application" launched in "chrome"
	 When search flights by source and destination for the day
		|src  |dest  |day  |
		|<src>|<dest>|<day>|
	 Then display the lowest price 
 Examples:
 | src 	| dest	  | day   |
 |	DXB  | LHR    |	23    |
 
 
 @LowestPrice2
 Scenario Outline: Getting the lowest price for the flights
	 Given "application" launched in "chrome"
	 When search flights by source and destination for the day
		|src  |dest  |day  |
		|<src>|<dest>|<day>|
	 Then display the lowest price 
 Examples:
 | src 	| dest	  | day   |
 |	DXB  | LHR    |	23    |
 
 @LowestPrice3
 Scenario Outline: Getting the lowest price for the flights
	 Given "application" launched in "chrome"
	 When search flights by source and destination for the day
		|src  |dest  |day  |
		|<src>|<dest>|<day>|
	 Then display the lowest price 
 Examples:
 | src 	| dest	  | day   |
 |	DXB  | LHR    |	23    |