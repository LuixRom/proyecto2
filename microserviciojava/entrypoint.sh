#!/bin/bash
java -cp ".:postgresql.jar:src" app &
sleep 5
java -cp ".:postgresql.jar:src" Seeder
wait
