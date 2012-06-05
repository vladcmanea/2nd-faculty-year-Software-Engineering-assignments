#ifndef _VLADMANEA_STUDENT
#define _VLADMANEA_STUDENT

// includ STL 
#include <string>

namespace VladManea
{
	using namespace std;

	// declar clasa student 
	class student
	{
	private:

		// declar atributele studentului 
		string _name;
		unsigned _markLab;
		unsigned _markProj;
		unsigned _markExam;

	public:

		// declar constructorul 
		student();

		// declar destructorul 
		~student();

		// declar metoda de setare a numelui 
		void setName(const string &name);

		// declar metoda de setare a notei la laborator 
		void setMarkLab(const unsigned &markLab);

		// declar metoda de setare a notei la proiect 
		void setMarkProj(const unsigned &markProj);

		// declar metoda de setare a notei la examen 
		void setMarkExam(const unsigned &markExam);

		// declar metoda de aflare a numelui 
		string getName();

		// declar metoda de aflare a notei la laborator 
		unsigned getMarkLab();

		// declar metoda de aflare a notei la proiect 
		unsigned getMarkProj();

		// declar metoda de aflare a notei la examen 
		unsigned getMarkExam();

		// declar metoda de aflare a notei finale 
		unsigned getMarkFinal();
	};
};

#endif
