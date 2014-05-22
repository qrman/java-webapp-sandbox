#!/bin/bash
psql -U postgres -c "drop database sandbox"
psql -U postgres -c "drop user sandbox"