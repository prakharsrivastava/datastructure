from collections import Counter

def most_frequent_words(text, num_words=10):
    # Preprocess the text: convert to lowercase and remove punctuation
    words = text.lower().split()

    # Count the frequency of each word
    word_counts = Counter(words)

    # Display the most frequent words and their frequencies
    for word, count in word_counts.most_common(num_words):
        print(f"{word} -> {count}")

# Example usage
text = "Python is great. Python is easy. Python is powerful and easy to learn."
most_frequent_words(text, 5)
