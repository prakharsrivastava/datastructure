class BollywoodTicketBooking:
    def __init__(self, size):
        self.size = size
        self.seats = [-1] * size  # -1 means empty seat

    # Hash function to get the initial seat number
    def hash_function(self, movie_id):
        return movie_id % self.size

    # Linear Probing: Search for the next available seat linearly
    def book_seat_linear(self, movie_id):
        seat = self.hash_function(movie_id)
        start = seat

        while self.seats[seat] != -1:  # Check if seat is occupied
            seat = (seat + 1) % self.size  # Move to the next seat
            if seat == start:  # If we loop back, no seat is available
                print(f"🎭 Housefull! No seat available for Movie {movie_id}")
                return
        
        self.seats[seat] = movie_id
        print(f"🎬 Movie {movie_id} booked at seat {seat} using Linear Probing.")

    # Quadratic Probing: Try jumping with increasing gaps (1², 2², 3²...)
    def book_seat_quadratic(self, movie_id):
        seat = self.hash_function(movie_id)
        i = 1
        start = seat

        while self.seats[seat] != -1:  # Check if seat is occupied
            seat = (seat + i ** 2) % self.size  # Quadratic jump
            i += 1
            if seat == start:  # If we loop back, no seat is available
                print(f"🎭 Housefull! No seat available for Movie {movie_id}")
                return

        self.seats[seat] = movie_id
        print(f"🎬 Movie {movie_id} booked at seat {seat} using Quadratic Probing.")

    # Double Hashing: Use a second hash function to find a new seat
    def second_hash(self, movie_id):
        return 7 - (movie_id % 7)  # A prime number less than size

    def book_seat_double_hashing(self, movie_id):
        seat = self.hash_function(movie_id)
        step = self.second_hash(movie_id)
        start = seat

        while self.seats[seat] != -1:  # Check if seat is occupied
            seat = (seat + step) % self.size  # Move using second hash function
            if seat == start:  # If we loop back, no seat is available
                print(f"🎭 Housefull! No seat available for Movie {movie_id}")
                return

        self.seats[seat] = movie_id
        print(f"🎬 Movie {movie_id} booked at seat {seat} using Double Hashing.")

    # Display the seat allocation
    def display_seats(self):
        print("🎟️ Current Seat Allocation:", self.seats)


# Sample Bollywood movie bookings
movies = [101, 102, 203, 304, 305, 406, 507, 608, 709, 810]

# Linear Probing Booking
print("\n🎟️ Booking with Linear Probing:")
linear_booking = BollywoodTicketBooking(10)
for movie in movies:
    linear_booking.book_seat_linear(movie)
linear_booking.display_seats()

# Quadratic Probing Booking
print("\n🎟️ Booking with Quadratic Probing:")
quadratic_booking = BollywoodTicketBooking(10)
for movie in movies:
    quadratic_booking.book_seat_quadratic(movie)
quadratic_booking.display_seats()

# Double Hashing Booking
print("\n🎟️ Booking with Double Hashing:")
double_hashing_booking = BollywoodTicketBooking(10)
for movie in movies:
    double_hashing_booking.book_seat_double_hashing(movie)
double_hashing_booking.display_seats()
