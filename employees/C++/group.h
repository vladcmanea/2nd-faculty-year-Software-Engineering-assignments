#ifndef _VLADMANEA_GROUP
#define _VLADMANEA_GROUP

// includ clasa student 
#include "student.h"

// includ STL 
#include <string>
#include <vector>
#include <iomanip>

namespace VladManea
{
	using namespace std;

	// declar clasa pentru grup 
	class group
	{
	private:

		// declar structura in care retin studentii 
		vector<student> _students;

	public:

		// declar constructorul 
		group();

		// declar destructorul 
		~group();

		// declar metoda de citire 
		void read(istream &in);

		// declar metoda de scriere 
		void write(ostream &out);
	};
};

#endif
