class MovieLister::CLI
    def call
        puts "Hello! Welcome to Movie Lister"
        get_user_input
    end

    def get_user_input
        puts "Would you like to see popular movies? Type: 'yes, y, or sure'."
        user_input = downcase_user_input_to_str(gets.strip)
        valid_input?(user_input) ? get_movies : get_user_input
    end 

    def downcase_user_input_to_str(user_input)
        user_input.to_s.downcase
    end

    def valid_input?(user_input)
        ['yes', 'y', 'sure'].include?(user_input) 
    end

    def get_movies
        MovieLister::API.new.get_data
    end

    def self.show(movies)
        movies.each.with_index(1) do |movie, i|
            puts "
                #{i}. Title: #{movie.original_title} 
                   Rating: #{movie.vote_average} Released: #{movie.release_date}
                   Overview: #{movie.overview}"
        end
    end
end