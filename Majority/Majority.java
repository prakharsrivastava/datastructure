import time

def moore_game():
  
    print("Your goal: Reach 1 billion transistors as fast as possible.")
    
    transistors = 1
    rounds = 0
    
    while transistors < 1000000000:  # 1 billion
        print(f"\n Round {rounds + 1}: You have {transistors} transistors")
        choice = input("Choose action: (A) Double (Moore's Law) or (B) Overclock (+50%)? ").strip().lower()
        
        if choice == "a":
            transistors *= 2
        elif choice == "b":
            transistors = int(transistors * 1.5)  # 50% increase
            if transistors % 3 == 0:  # Random failure condition
                print(" Overclock failed! System crash. Restarting with half transistors.")
                transistors //= 2
        else:
            print(" Invalid choice! Defaulting to Moore's Law doubling.")
            transistors *= 2
        
        rounds += 1
        time.sleep(0.5)  # Delay for realism

    print(f"\n You reached 1 billion transistors in {rounds} rounds! ")

# Run the game
moore_game()
