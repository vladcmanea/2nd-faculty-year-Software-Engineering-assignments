// includ grupul 
#include "group.h"
using namespace std;

// definesc constructorul 
VladManea::group::group()
{

}

// definesc destructorul 
VladManea::group::~group()
{
	// eliberez vectorul de studenti 
	_students.clear();
}

// definesc metoda de citire 
void VladManea::group::read(istream &in)
{
	unsigned N;
	using namespace VladManea;

	// citesc numarul de elevi 
	if (!(in >> N))
		throw("[group::read] read error: could not read N");

	// verific N 
	if (N <= 0)
		throw("[group::read] read error: N is 0");

	// iterez pentru cei N elevi 
	for (unsigned i = 0; i < N; ++i)
	{
		// declar variabile intermediare 
		string name;
		unsigned markLab, markProj, markExam;

		// citesc numele unui elev 
		if (!(in >> name))
			throw("[group::read] read error: name could not be read");

		// citesc nota laborator 
		if (!(in >> markLab))
			throw("[group::read] read error: laboratory mark could not be read");

		// citesc nota proiect 
		if (!(in >> markProj))
			throw("[group::read] read error: project mark could not be read");

		// citesc nota examen 
		if (!(in >> markExam))
			throw("[group::read] read error: exam mark could not be read");

		// construiesc un elev 
		student stud;
		stud.setName(name);
		stud.setMarkLab(markLab);
		stud.setMarkProj(markProj);
		stud.setMarkExam(markExam);

		// pun in lista studentilor studentul construit 
		_students.push_back(stud);
	}
}

// definesc metoda de scriere 
void VladManea::group::write(ostream &out)
{
	using namespace VladManea;

	// calculez maximul lungimii unui nume 
	unsigned max = 4;

	// calculez maximul lungimii unui nume 
	for (vector<student>::iterator it = _students.begin(); it != _students.end(); ++it)
		if (it->getName().length() > max)
			max = it->getName().length();

	// desenez stelute 
	for (unsigned i = 0; i < max + 6 + 3 + 7 + 6 + 5; ++i)
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

	// scriu un sfarsit de linie 
	if (!(out << '\n'))
		throw("[group::write] write error: enter could not be written");

	// scriu steluta 
	if (!(out << '*'))
		throw("[group::write] write error: star could not be written");

	// scriu nume 
	if (!(out << setw(max) << "Nume"))
		throw("[group::write] write error: name header could not be written");

	// scriu restul 
	if (!(out << "*Lab*Proiect*Examen*Final*\n"))
		throw("[group::write] write error: star could not be written");

	// desenez stelute 
	for (unsigned i = 0; i < max + 6 + 3 + 7 + 6 + 5; ++i)
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

	// scriu un sfarsit de linie 
	if (!(out << '\n'))
		throw("[group::write] write error: enter could not be written");

	// parcurg studentii 
	for (vector<student>::iterator it = _students.begin(); it != _students.end(); ++it)
	{
		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu numele studentului 
		if (!(out << setw(max) << it->getName()))
			throw("[group::write] write error: name could not be written");

		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu nota laborator a studentului 
		if (!(out << setw(3) << it->getMarkLab()))
			throw("[group::write] write error: laboratory mark could not be written");

		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu nota proiect a studentului 
		if (!(out << setw(7) << it->getMarkLab()))
			throw("[group::write] write error: project mark could not be written");

		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu nota examen a studentului 
		if (!(out << setw(6) << it->getMarkExam()))
			throw("[group::write] write error: exam mark could not be written");

		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu nota finala a studentului 
		if (!(out << setw(5) << it->getMarkFinal()))
			throw("[group::write] write error: final mark could not be written");

		// scriu steluta 
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

		// scriu un sfarsit de linie 
		if (!(out << '\n'))
			throw("[group::write] write error: enter could not be written");
	}

	// desenez stelute 
	for (unsigned i = 0; i < max + 6 + 3 + 7 + 6 + 5; ++i)
		if (!(out << '*'))
			throw("[group::write] write error: star could not be written");

	// scriu un sfarsit de linie 
	if (!(out << '\n'))
		throw("[group::write] write error: enter could not be written"); 
}
