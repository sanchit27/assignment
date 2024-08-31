#!/bin/bash

# Directories
INPUT_DIR="input"
EXPECTED_DIR="output"
ACTUAL_DIR="actual_output"

# Ensure the actual output directory exists
mkdir -p $ACTUAL_DIR

# Initialize a variable to track test success
all_passed=true

# Iterate over each input file
for input_file in $INPUT_DIR/*.txt
do
    # Extract the base name (e.g., input1 from input1.txt)
    base_name=$(basename $input_file .txt)
    
    # Define the corresponding expected output file
    expected_file="$EXPECTED_DIR/expected${base_name:5}.txt"
    
    # Define the output file where the program's output will be stored
    actual_file="$ACTUAL_DIR/$base_name.txt"
    
    # Run the Java program with the input file and redirect the output
    java -cp target/classes moneylion.App < $input_file > $actual_file
    
    # Compare the actual output with the expected output
    if diff $actual_file $expected_file > /dev/null; then
        echo "Test $base_name passed."
    else
        echo "Test $base_name failed!"
        all_passed=false
    fi
done

# Summary
if $all_passed; then
    echo "All tests passed!"
else
    echo "Some tests failed. Check the output above for details."
fi

