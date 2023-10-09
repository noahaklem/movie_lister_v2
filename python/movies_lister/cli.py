import setup

class CLI:

    def call(self):
        print("Hello! Welcome to Movie Lister.")
        self.get_input()

    def get_input(self):
        print("Would you like to see trending movies? Type: 'yes, y, or sure'.")
        user_input = input()
        user_input = self.convert_user_input(user_input)
        if setup.helper.valid_input(user_input):
            self.get_movies()
        else:
            self.get_input()

    def convert_user_input(self, user_input):
        return str(user_input.strip()).lower()
        
    def get_movies(self):
        setup.api_class.API.get_data()
        
    def show(self, movies):
        for i, movie in enumerate(movies): 
            print(f"{i+1}. Title: {movie.original_title} Rating: {movie.vote_average} Release Date: {movie.release_date}")
            print(f"Overview: {movie.overview}")
        