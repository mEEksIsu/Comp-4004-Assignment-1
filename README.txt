Miika Heimonen-MacKay
100828239
https://github.com/mEEksIsu/Comp-4004-Assignment-1/

Features / tests:

Card strings parsed and turned into Cards / CardTest.Java 
Hand holds a list of cards and generates a score based on the type of hand / HandTest.java 
Players are automatically assigned correct IDs / public void playerIDShouldIncrementAutomatically()
Every round, the amount of players, the player IDs, and hands are inputted and parsed / public void shouldParseStringsAndGeneratePlayerHands()
Each player's hand is scored and used to assign them ranks / public void shouldGenerateCorrectScoresForHands() { public void shouldCorrectlyRankPlayers() {

Requirements / tests:

1: Test for Duplicate cards and suites / public void shouldThrowExceptionIfCardIsDuplicate() {
2: Test for Minimum and maximum number of players (2 to 4) / public void shouldThrowExceptionIfIDIsInvalid() {
3: Test to ensure there are 5 cards dealt to each player / public void shouldThrowExceptionIfHandHasWrongNumberOfCards() {
4: Hands are ranked in order ! / public void shouldCorrectlyRankPlayers() {
5: Test for duplicate hands e.g. Royal Flush and ensure they are listed at the top of the ranking order / public void shouldCorrectlyRankPlayers() {
6: Test for invalid cards e.g. fourteenClubs, threeShovels, thDiamonds etc. / public void shouldThrowExceptionIfCardIsInvalid() {
7: Test for valid player ids / public void shouldThrowExceptionIfIDIsInvalid() {
8: Ensure the order of entry is correct - e.g. player id and then the cards / public void shouldThrowExceptionIfIDComesLater() {

Instructions: import project into Eclipse, run Game.java and follow instructions in console 

