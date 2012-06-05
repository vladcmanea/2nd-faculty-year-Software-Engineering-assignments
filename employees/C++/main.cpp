#include "group.h"

#include <iostream>
using namespace std;

int main()
{
	try
	{
		using namespace VladManea;
		group grp;
		grp.read(cin);
		grp.write(cout);
	}
	catch (char *e)
	{
		cerr << e << '\n';
	}

	return 0;
}