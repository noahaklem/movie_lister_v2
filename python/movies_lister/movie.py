import setup

class Movie:
    all = []

    def __init__(self, original_title, overview, release_date, vote_average):
        self.__original_title = original_title
        self.__overview = overview
        self.__release_date = release_date
        self.__vote_average = vote_average
        self.save()

    @classmethod
    def new_from_api(cls, data):
        for movie in data:
            cls(
                original_title = movie['original_title'],
                overview = movie['overview'],
                release_date = movie['release_date'],
                vote_average = movie['vote_average']
            )
        cli = setup.cli_class.CLI
        cli.show(cli, Movie.all)

    def save(self):
        Movie.all.append(self)

    @property
    def original_title(self):
        return self.__original_title 
    
    @property
    def overview(self):
        return self.__overview

    @property
    def release_date(self):
        return self.__release_date

    @property
    def vote_average(self):
        return self.__vote_average

