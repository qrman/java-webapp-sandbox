#!/bin/bash
psql -U postgres -c "create user sandbox with password 'sandbox';"
psql -U postgres -c "create database sandbox with owner sandbox;"