// includ studentul 
#include "student.h"
using namespace std;

// definesc constructorul 
VladManea::student::student()
{
	// initializez numele 
	_name = "";

	// initializez nota la examen 
	_markExam = 0;

	// initializez nota la proiect 
	_markProj = 0;

	// initializez nota la laborator 
	_markLab = 0;
}

// definesc destructorul 
VladManea::student::~student()
{
	// nu am continut 
}

// definesc metoda de setare a numelui 
void VladManea::student::setName(const string &name)
{
	// verific numele si, daca e corect, il pun 
	if (name.length())
		_name = name;
	else
		throw("[student::setName] set error: name is null");
}

// definesc metoda de setare a notei laborator 
void VladManea::student::setMarkLab(const unsigned &markLab)
{
	// verific nota laborator si, daca e corecta, o pun 
	if (markLab <= 10)
		_markLab = markLab;
	else
		throw("[student::setMarkLab] set error: laboratory mark is greater than 10");
}

// definesc metoda de setare a notei proiect 
void VladManea::student::setMarkProj(const unsigned &markProj)
{
	// verific nota proiect si, daca e corecta, o pun 
	if (markProj <= 10)
		_markProj = markProj;
	else
		throw("[student::setMarkProj] set error: project mark is greater than 10");
}

// definesc metoda de setare a notei examen 
void VladManea::student::setMarkExam(const unsigned &markExam)
{
	// verific nota examen si, daca e corecta, o pun 
	if (markExam <= 10)
		_markExam = markExam;
	else
		throw("[student::setMarkExam] set error: exam mark is greater than 10");
}

// definesc metoda de aflare a numelui 
string VladManea::student::getName()
{
	// intorc numele 
	return _name;
}

// definesc metoda de aflare a notei laborator 
unsigned VladManea::student::getMarkLab()
{
	// intorc nota finala 
	return _markLab;
}

// definesc metoda de aflare a notei proiect 
unsigned VladManea::student::getMarkProj()
{
	// intorc nota finala 
	return _markProj;
}

// definesc metoda de aflare a notei examen 
unsigned VladManea::student::getMarkExam()
{
	// intorc nota finala 
	return _markExam;
}

// definesc metoda de aflare a notei finale 
unsigned VladManea::student::getMarkFinal()
{
	// intorc nota finala 
	return (2 * _markExam + _markLab + _markProj) / 4;
}
