#some practice tests written here

require_relative '../config/environment'

context MovieLister::CLI do
    describe '#call' do
        it 'should greet the use when on call' do
            expect($stdout).to receive(:puts).with("Hello! Welcome to Movie Lister")
            MovieLister::CLI.new.call
        end
    end

    describe '#get_user_input' do
        it 'should ask the user if they would like to see current movies' do
            expect($stdout).to receive(:puts).with('Would you like to see popular movies?')
            MovieLister::CLI.new.get_user_input
        end
    end
end