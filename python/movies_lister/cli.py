from movies_lister.subpackage.valid_input import valid_input
class CLI:

    def call(self):
        print("Hello! Welcome to Movie Lister.")
        self.get_input()

    def get_input(self):
        print("Would you like to see trending movies? Type: 'yes, y, or sure'.")
        user_input = input()
        user_input = self.convert_user_input(user_input)
        if valid_input(user_input):
            print("onto the next")
        else:
            self.get_input()

    def convert_user_input(self, user_input):
        return str(user_input.strip()).lower()
        
    def get_movies(self):
        pass