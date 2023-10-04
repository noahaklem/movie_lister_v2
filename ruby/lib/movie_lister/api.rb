class MovieLister::API 
    Dotenv.load
    
    def initialize
        @base_url = "https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1"
        @auth = "Bearer #{ENV['SECRET_KEY']}"
    end

    def get_data
        # response = HTTParty.get(@base_url, headers: {
        #     Authorization: @auth
        # } )
        # MovieLister::Movie.new_from_api(response['results'])
        binding.pry
    end


end