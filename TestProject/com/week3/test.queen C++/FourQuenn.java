//// This code is due to Timothy Budd, from the book
//// "An Introduction to Object-Oriented Programming"
//
//class Queen {
//	int row;
//	int column;
//	Queen * neighbor;
//	int canAttack(int r, int c);
//	int testOrAdvance();
//public:
//	Queen(int c, Queen * ngh);
//	int first();
//	int next();
//	void print();
//};
//
//#include <cstdio>
//#include "Queen.h"
//
//// construct new queen, setting neighbor 
//// and column number
//Queen::Queen(int c, Queen * ngh) {
//	column = c; neighbor = ngh; 
//}
//
//
//// check to see if queen or neighbor can attack
//// position
//int Queen::canAttack(int r, int c) {
//	int cd;
//	if (row == r) return 1;
//	cd = c - column;
//	if ((row + cd == r) || (row - cd == r)) return 1;
//	if (neighbor) return neighbor->canAttack(r, c);
//	return 0;
//}
// // compute first legal position for queen and neighbor
//int Queen::first() {
//	row = 1;
//	if (neighbor && neighbor->first())
//		return testOrAdvance();
//	return 1;
//}
//
//// test or advance a position
//int Queen::testOrAdvance() {
//	if (neighbor && neighbor->canAttack(row, column))
//		return next();
//	return 1;
//}
//
//// compute another legal position for queen
//// and neighbor
//int Queen::next() {
//	if (row == 8) {
//		if (!(neighbor && neighbor->next()))
//			return 0;
//		row = 0;
//	}
//	row = row + 1;
//	return testOrAdvance();
//}
//
//// print solution
//void Queen::print() {
//	if (neighbor) neighbor->print();
//	printf("Column %d row %d\n", column, row);
//}
//
//void main() {
//	Queen * lastQueen = 0;
//	for (int i = 1; i <= 8; i++)
//		lastQueen = new Queen(i, lastQueen);
//	if (lastQueen->first()) lastQueen->print();
//	char c;
//	std::cin>> c;
//}