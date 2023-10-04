# The app needs to use bundler and require the gems

require 'bundler/setup'
Bundler.require(:default, :development)

# require any files here (such as: movie class, api class, movie_lister class )
# this is a nice way to load all files and manage it in one place instead of multiple locations

require_relative '../lib/concerns/movie_lister'
require_relative '../lib/movie_lister/cli'
require_relative '../lib/movie_lister/api'