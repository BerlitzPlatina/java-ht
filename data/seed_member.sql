INSERT INTO users (username, first_name, last_name, email, password)
SELECT 
    'user' || i,   -- Unique username
    'First' || i,  -- First name
    'Last' || i,   -- Last name
    'user' || i || '@example.com', -- Unique email
    'password' || i
FROM generate_series(1, 50) AS i;


DO $$ 
DECLARE 
    i INT;
    parent_id INT;
    user_id INT;
BEGIN
    -- The first user is the ancestor (grandfather)
    INSERT INTO members (user_id, family_id, parent_id)
    VALUES (1, 1, NULL)
    RETURNING id INTO parent_id;

    -- Generate other members
    FOR i IN 2..50 LOOP
        -- Assign user_id sequentially
        user_id := i;

        -- Assign random parent_id from previous users (to create a tree structure)
        INSERT INTO members (user_id, family_id, parent_id, created_at, updated_at)
        VALUES (user_id, 1, (SELECT id FROM members ORDER BY RANDOM() LIMIT 1), NOW(), NOW());
    END LOOP;
END $$;