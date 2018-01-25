#include <QApplication>
#include <QPushButton>

int main(int argc, char *argv[])
{
	QApplication app(argc, argv);

	QPushButton hello("Hello world!");

	hello.show();
	return app.exec();
}
