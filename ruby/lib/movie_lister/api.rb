class MovieLister::API 
    base_url = "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1}"

    def get_data
        response = HTTParty.get('#{base_url}?#{ENV[API_TOKEN]}')
        binding.pry
    end


end